import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

public class RadarScanner extends JPanel {

    static class Host {
        String ip;
        Point pos;
        boolean online;
        int alpha = 255;

        Host(String ip, Point pos) {
            this.ip = ip;
            this.pos = pos;
            this.online = true;
        }
    }

    private final Map<String, Host> hosts = new HashMap<>();
    private double angle = 0;
    private int radarRadius = 200;

    public RadarScanner() {
        setPreferredSize(new Dimension(650, 520));
        setBackground(Color.BLACK);

        // 🔄 Animation radar (Timer Swing forcé)
        javax.swing.Timer timer = new javax.swing.Timer(25, e -> {
            angle += 0.04;
            for (Host h : hosts.values()) {
                if (!h.online) h.alpha = Math.max(0, h.alpha - 2);
            }
            repaint();
        });
        timer.start();

        // Scan en boucle
        new Thread(this::scanLoop).start();
    }

    // 🌐 Base IP auto
    private String getBaseIP() {
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            while (nets.hasMoreElements()) {
                NetworkInterface net = nets.nextElement();
                if (!net.isUp() || net.isLoopback()) continue;

                for (InetAddress addr : Collections.list(net.getInetAddresses())) {
                    if (addr.getHostAddress().contains(".")) {
                        String ip = addr.getHostAddress();
                        return ip.substring(0, ip.lastIndexOf('.')) + ".";
                    }
                }
            }
        } catch (Exception ignored) {}
        return "192.168.1.";
    }

    // 🔁 Scan continu
    private void scanLoop() {
        String baseIP = getBaseIP();
        Random rand = new Random();

        while (true) {
            Set<String> found = new HashSet<>();

            for (int i = 1; i <= 254; i++) {
                String ip = baseIP + i;
                try {
                    InetAddress addr = InetAddress.getByName(ip);
                    long start = System.currentTimeMillis();

                    if (addr.isReachable(600)) {
                        found.add(ip);
                        long ping = System.currentTimeMillis() - start;

                        int r = (int) Math.min(radarRadius,
                                (ping / 120.0) * radarRadius);

                        double a = rand.nextDouble() * Math.PI * 2;
                        int x = (int) (r * Math.cos(a));
                        int y = (int) (r * Math.sin(a));

                        hosts.putIfAbsent(ip, new Host(ip, new Point(x, y)));
                        Host h = hosts.get(ip);
                        h.pos = new Point(x, y);
                        h.online = true;
                        h.alpha = 255;
                    }
                } catch (Exception ignored) {}
            }

            // 🔴 Marquer les IP perdues
            for (Host h : hosts.values()) {
                if (!found.contains(h.ip)) {
                    h.online = false;
                }
            }

            try { Thread.sleep(4000); } catch (InterruptedException ignored) {}
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int cx = getWidth() / 2 + 80;
        int cy = getHeight() / 2;

        // 🟢 Cercles radar
        g2.setColor(new Color(0, 255, 0, 80));
        for (int i = 1; i <= 4; i++) {
            int r = radarRadius * i / 4;
            g2.drawOval(cx - r, cy - r, r * 2, r * 2);
        }

        // 📡 Traînée radar
        for (int i = 0; i < 10; i++) {
            double a = angle - i * 0.05;
            g2.setColor(new Color(0, 255, 0, 120 - i * 10));
            int x = (int) (radarRadius * Math.cos(a));
            int y = (int) (radarRadius * Math.sin(a));
            g2.drawLine(cx, cy, cx + x, cy + y);
        }

        // 🟢 / 🔴 Hôtes + IP
        for (Host h : hosts.values()) {
            int px = cx + h.pos.x;
            int py = cy + h.pos.y;

            if (h.online) {
                g2.setColor(Color.GREEN);
                g2.fillOval(px - 4, py - 4, 8, 8);
            } else if (h.alpha > 0) {
                g2.setColor(new Color(255, 0, 0, h.alpha));
                g2.fillOval(px - 4, py - 4, 8, 8);
            }

            g2.setColor(Color.GREEN);
            g2.drawString(h.ip, px + 6, py - 6);
        }

        // 📋 Liste IP
        int y = 40;
        g2.setColor(Color.GREEN);
        g2.drawString("IP détectées :", 10, 20);

        for (Host h : hosts.values()) {
            g2.setColor(h.online ? Color.GREEN : Color.RED);
            g2.drawString(h.ip + (h.online ? "  [ON]" : "  [OFF]"), 10, y);
            y += 14;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Radar Réseau – IP visibles");
        RadarScanner radar = new RadarScanner();

        JSlider slider = new JSlider(120, 260, 200);
        slider.addChangeListener(e -> radar.radarRadius = slider.getValue());

        frame.setLayout(new BorderLayout());
        frame.add(radar, BorderLayout.CENTER);
        frame.add(slider, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

# Radar_reseau
Radar réseau et un logiciel java a compiler et a utiliser (dans le cadre légal)
Un **scanner réseau graphique en Java** à compiler et utiliser (dans un cadre **légal** uniquement).  
Ce logiciel permet d’analyser ton réseau local et d’afficher visuellement les appareils trouvés (IP, Wi-Fi, Bluetooth) sur un radar animé.

---

## Description

Ce projet implémente un radar réseau avec interface graphique en Java :

- Détection des appareils sur le réseau local (ping IP)
- Scanner Wi-Fi (SSID + puissance) via commandes système Windows
- Détection Bluetooth via PowerShell
- Affichage graphique en temps réel
- Liste des appareils avec leur état (ON / OFF)

Le projet est conçu pour être **facile à compiler** et à utiliser sur Windows 11 (éducation ou autre).  
Il fonctionne en exploitant les outils systèmes (netsh, PowerShell) et respecte le cadre législatif d’analyse réseau sur le réseau local.

---

## Fonctionnalités

| Fonctionnalité | Description |
| -------------- | ----------- |
| 🌐 Scan réseau IP | Balayage du réseau local pour détecter les IP actives |
| 📶 Détection Wi-Fi | Récupère les SSID et leur puissance |
| 🔵 Détection Bluetooth | Liste les appareils Bluetooth connectés |
| 📊 Radar graphique | Animation radar avec points et noms |
| 📋 Liste détaillée | Affiche les appareils détectés et leur état |

---

## Pré-requis

- Système : **Windows 11**
- Java 17 (adoptium conseilé) ou supérieur (JDK installé)
- Terminal PowerShell disponible

---

## 📂 Structure du dépôt

📦Radar_reseau
┣ 📜README.md
┣ 📜RadarScanner.java

---

## ▶️ Compilation & Exécution

Ouvre un terminal (PowerShell ou CMD) dans le dossier du projet, puis :

Compile
```bath
# Compile
javac RadarScanner.java

# Exécute
java RadarScanner

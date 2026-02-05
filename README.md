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
```
📦Radar_reseau
┣ 📜README.md
┣ 📜RadarScanner.java
```
---

## ▶️ Compilation & Exécution

Ouvre un terminal (PowerShell ou CMD) dans le dossier du projet, puis :

Compile
```bath
# Compile
javac RadarScanner.java

# Exécute
java RadarScanner
```
---

## Aide et Comantaire

Si pour une raison inconue le programme ne fonctione pas ou vous avez besion d'aide n'ésite pas a nous envoiez un mail ou un commentaire a : m8m7g0pkd@mozmail.com

Pour télécharger Aduptium : https://release-assets.githubusercontent.com/github-production-release-asset/372925194/96387494-5b30-4796-8ce7-988fca9caa6b?sp=r&sv=2018-11-09&sr=b&spr=https&se=2026-02-04T08%3A57%3A00Z&rscd=attachment%3B+filename%3DOpenJDK17U-jdk_x64_windows_hotspot_17.0.17_10.msi&rsct=application%2Foctet-stream&skoid=96c2d410-5711-43a1-aedd-ab1947aa7ab0&sktid=398a6654-997b-47e9-b12b-9515b896b4de&skt=2026-02-04T07%3A56%3A14Z&ske=2026-02-04T08%3A57%3A00Z&sks=b&skv=2018-11-09&sig=8aegXvC9Se%2BBot%2F0Cj1DFA%2FQfVfGUGxhVP1v0U6pyxY%3D&jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmVsZWFzZS1hc3NldHMuZ2l0aHVidXNlcmNvbnRlbnQuY29tIiwia2V5Ijoia2V5MSIsImV4cCI6MTc3MDE5Njc0NSwibmJmIjoxNzcwMTkzMTQ1LCJwYXRoIjoicmVsZWFzZWFzc2V0cHJvZHVjdGlvbi5ibG9iLmNvcmUud2luZG93cy5uZXQifQ.mhnWExmOeYRswoZLDqQ064i9AHJ5YcAcBy1RDKQDlxo&response-content-disposition=attachment%3B%20filename%3DOpenJDK17U-jdk_x64_windows_hotspot_17.0.17_10.msi&response-content-type=application%2Foctet-stream
(le link vous télécharge directement Aduptium)

Merci pour votre contribution !!!

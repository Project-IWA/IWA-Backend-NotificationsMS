# IWA-Back-NotificationsMS
Le microservice de gestion des notifications du backend du projet IWA.

# **🚀 Guide d'Installation du Microservice**

## **🌟 Fonctionnalités Principales**

- Envoie des notifications aux administrateurs concernant les demandes de suppression.

## **🔧 Prérequis**

- **Java**: 🌟 Version 17.
- **Spring Boot**: 🚀 Versions 3.1.5.
- **Docker**: 🐳 Pour orchestrer les conteneurs des microservices et des bases de données.
- **Maven**: 🛠 Pour la gestion des dépendances et la construction des microservices.
- **Docker Compose**: 🎼 Pour orchestrer harmonieusement le déploiement des microservices et des bases de données.
- **Un IDE**: 💻 De préférence **IntelliJ IDEA** pour un développement fluide.

## **📦 Installation et Configuration**

1. **Clonage du Répertoire de Code Source**:
    - 📂 Clonez le répertoire contenant le code source du microservice.
2. **Installation de Java 17**:
    - ☕ Installez Java 17 et configurez les variables d'environnement **`JAVA_HOME`** et **`PATH`**.
3. **Installation de Docker et Docker Compose**:
    - 🐳 Téléchargez et installez Docker et Docker Compose.
4. **Configuration des Bases de Données**:
    - 🗄 Assurez-vous que Docker Compose est configuré pour démarrer les instances de bases de données nécessaires.

## **🚀 Lancement du Microservice**

1. **Préparation du Microservice**:
    - 🛠 Dans le répertoire du microservice, exécutez les commandes suivantes pour construire l'application :

        ```bash
          mvn clean package -DskipTests
        ```
      --
      ```bash
        mvn install package -DskipTests
        ```

    - 📦 Ces commandes génèrent le fichier JAR nécessaire pour le microservice tout en évitant les tests unitaires.
2. **Construction et Lancement avec Docker Compose**:
    - 🏗 Exécutez **`docker-compose build`** pour construire les images Docker du microservice.
    - 🌐 Lancez les services avec **`docker-compose up`**.

## **🔍 Vérification**

- 🌐 Après le démarrage du service, vérifiez leur fonctionnement en accédant aux endpoints via un navigateur ou Postman.

## **⚠️ Notes Importantes**

- 🚀 Assurez-vous de démarrer Docker Compose avant de lancer le microservice.
- 🛑 L'utilisation de **`DskipTests`** dans les commandes Maven est essentielle pour éviter des tests de connexion prématurés à la base de données.

---

## **👨‍💻 Équipe de Développement**

- Karim AIDIBI
- Marwane TOURY
- Jason MORET

IG5 2023 - 2024
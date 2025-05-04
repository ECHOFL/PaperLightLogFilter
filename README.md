# Genlife-LogFilter

Un plugin Minecraft permettant de filtrer les logs de la console selon des motifs configurables.

## Description

Genlife-LogFilter est un plugin Bukkit/Paper léger qui permet aux administrateurs de serveur de filtrer les messages indésirables dans la sortie de la console. Cela peut être particulièrement utile pour réduire le bruit dans la console et se concentrer sur les messages importants.

## Fonctionnalités

- Filtrage des messages indésirables dans les logs selon des motifs configurables
- Rechargement de la configuration sans redémarrer le serveur
- Accès aux commandes basé sur les permissions
- Implémentation simple et légère

## Installation

1. Téléchargez la dernière version depuis la [page des releases](https://github.com/fliqq/Genlife-LogFilter/releases)
2. Placez le fichier JAR dans le dossier `plugins` de votre serveur
3. Démarrez ou redémarrez votre serveur
4. Configurez le plugin en modifiant le fichier `config.yml` dans le répertoire `plugins/GenlifeLogFilter`

## Configuration

Après le premier démarrage, un fichier de configuration par défaut sera créé à `plugins/GenlifeLogFilter/config.yml` :

```yaml
config:
  # Messages à afficher aux utilisateurs
  no-permission-message: "&cVous n'avez pas la permission &7logfilter.reload"
  config-reloaded-message: "&cGenlifeLogFilter &aConfiguration rechargée!"
  
  # Liste des chaînes à filtrer dans la sortie de la console
  # Tout message de log contenant ces chaînes sera masqué
  filter:
    - "Message exemple à filtrer"
    - "Un autre message à filtrer"
    - "/login"
```

## Commandes

| Commande | Description | Permission |
|---------|-------------|------------|
| `/reloadlogfilter` | Recharge la configuration du plugin | `logfilter.reload` |

## Permissions

| Permission | Description | Par défaut |
|------------|-------------|------------|
| `logfilter.reload` | Permet de recharger la configuration du plugin | OP |

## API

Ce plugin utilise le système de filtrage de Log4j pour intercepter et filtrer les messages de log. Les développeurs peuvent étendre les fonctionnalités en accédant à la classe `LogFilter`.

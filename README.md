# PaperLight-LogFilter

## Description

Genlife-LogFilter est un plugin Bukkit/Paper léger qui permet aux administrateurs de serveur de filtrer les messages indésirables dans la sortie de la console. Cela peut être particulièrement utile pour réduire le bruit dans la console et se concentrer sur les messages importants. Permet aussi de supprimer les messages /login <mdp> dans la console pour les serveurs offline.

## Fonctionnalités

- Filtrage des messages indésirables dans les logs selon des motifs configurables
- Rechargement de la configuration sans redémarrer le serveur
- Accès aux commandes basé sur les permissions
- Implémentation simple et légère

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

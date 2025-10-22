# 🏝️ Lucky Pillars

![GitHub Release (latest by date)](https://img.shields.io/github/v/release/Mikolaj0524/LuckyPillars?label=latest%20release)
![GitHub License](https://img.shields.io/github/license/Mikolaj0524/LuckyPillars)
![PaperMC](https://img.shields.io/badge/Server-Paper%201.20+-blue)
![Java](https://img.shields.io/badge/Java-17+-orange)
![PlaceholderAPI](https://img.shields.io/badge/PlaceholderAPI-Supported-success)

A fast-paced PvP minigame where players spawn on **floating pillars about 40 blocks above an island**. Every few seconds, they receive random items and must fight to be the last one standing. The arena automatically resets after each round, keeping the gameplay smooth and repeatable.

---

## ⚙️ Features

* Floating pillar-based PvP arena above an island
* Random item drops every configurable number of seconds
* Fully automatic game reset after each round
* Customizable spawn, sign, and pillar locations
* Banned block protection to prevent exploits
* PlaceholderAPI integration
* Simple configuration and fast setup

---

## 💬 Commands

| Command                 | Description               | Permission             |
| ----------------------- | ------------------------- | ---------------------- |
| `/luckypillars restart` | Restarts the current game | `luckypillars.restart` |
| `/luckypillars rlc`     | Reloads the configuration | `luckypillars.rlc`     |

Players can start the game by **clicking the configured sign**.

---

## 🔐 Permissions

| Permission             | Description                 |
| ---------------------- | --------------------------- |
| `luckypillars.start`   | Allows starting the game    |
| `luckypillars.restart` | Allows restarting the game  |
| `luckypillars.rlc`     | Allows reloading the config |

---

## 🧩 PlaceholderAPI Placeholders

| Placeholder                | Description                                |
| -------------------------- | ------------------------------------------ |
| `%luckypillars_time%`      | Current game time                          |
| `%luckypillars_kills%`     | Player kill count                          |
| `%luckypillars_gameState%` | Current game state (`Running` / `Waiting`) |
| `%luckypillars_players%`   | Number of active players                   |

---

## 🧱 Configuration (`config.yml`)

Example configuration:

```yaml
prefix: "&8 [&bLP&8] &b» &7"

timeBetweenDrop: 4

bannedBlocks:
  - COMMAND_BLOCK
  - CHAIN_COMMAND_BLOCK
  - REPEATING_COMMAND_BLOCK
  - COMMAND_BLOCK_MINECART
  - JIGSAW
  - STRUCTURE_BLOCK
  - STRUCTURE_VOID
  - BARRIER
  - DEBUG_STICK
  - LIGHT
  - BEDROCK
  - END_STONE
  - CHORUS_PLANT
  - CHORUS_FLOWER
  - DRAGON_EGG

spawn:
  x: 0.5
  y: 131
  z: 0.5
  yaw: 180

sign:
  x: 0
  y: 132
  z: -5
  facing: SOUTH

pillars:
  1:
    x: 0
    y: 102
    z: 15
    yaw: 180
  2:
    x: 10
    y: 102
    z: 10
    yaw: 135
  3:
    x: 15
    y: 102
    z: 0
    yaw: 90
  4:
    x: 10
    y: 102
    z: -10
    yaw: 45
  5:
    x: 0
    y: 102
    z: -15
    yaw: 0
  6:
    x: -10
    y: 102
    z: -10
    yaw: -45
  7:
    x: -15
    y: 102
    z: 0
    yaw: -90
  8:
    x: -10
    y: 102
    z: 10
    yaw: -135
```

---

## 🧠 Setup Instructions

1. Build your own island and **floating pillars** about 40 blocks above it.
2. Set your **spawn**, **sign**, and **pillar** coordinates in `config.yml`.
3. Adjust `bannedBlocks` to control which blocks players can’t get.
4. Reload the config with `/luckypillars rlc`.
5. Click the start sign to begin the game.

> ⚠️ **Building alert:**
> In `bannedBlocks`, you must include **all blocks that your map is built from**, so they don’t drop as random items during gameplay.

> ⚠️ **World height guidelines:**
>
> * Players that fall below `Y < 50` automatically die.
> * Players can build and do anything above `Y = 120`.
> * You should build your **lobby** above `Y = 120`.
> * Recommended bottom of the map is around `Y = 60`.

---

## 🧾 Notes

* The plugin automatically resets the game and the map after each round.
* Random item drops keep every match unique.
* Perfect for small PvP servers or minigame hubs.
* Designed for **Paper 1.20+**.

---

## 📦 License

This project is licensed under the [License](LICENSE).

---
README by ChatGPT
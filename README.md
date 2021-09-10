# Project

## Aims

* Appreciate issues in user interface design

* Learn practical aspects of graphical user interface programming

* Learn more about the Java class libraries

* Learn the application of design patterns.

## Overview

Follow an agile development process to design and implement a desktop dungeon like maze game. The final should be of professional quality, user-friendly, and demonstrate the knowledge and skills in OOP, Java and JavaFX


## Project setup

This project requires JavaFX to run

Open the root directory of the repository in VSCode, and click the *"Run"* link above the *main* method of **DungeonApplication.java**

The following version of the JavaFX JDK is recommended

https://gluonhq.com/products/javafx/


## Preliminary client requirements

The client desires an application that lets the user move a player around a dungeon and try to overcome various challenges in order to "complete" the dungeon by reaching some goal. The simplest form of such a puzzle is a maze, where the player must find their way from the starting point to the exit.

![Maze][maze]

More advanced puzzles may contain things like boulders that need to be pushed onto floor switches,

![Boulders][boulders]

enemies that need to be fought with weapons, or collectables like potions and treasure.

![Advanced dungeon][advanced]

### Dungeon layout

To be specific, the layout of each dungeon is defined by a grid of squares, each of which may contain one or more entities. The different types of entities are as follows:

| Entity               | Example | Description                             |
| ------               | ------- | --------------------------------------- |
| Player               | ![Player][player] | Can be moved up, down, left, and right into adjacent squares, provided another entity doesn't stop them (e.g. a wall). |
| Wall                 | ![Wall][wall] | Blocks the movement of the player, enemies and boulders. |
| Exit                 | ![Exit][exit] | If the player goes through it the puzzle is complete.  |
| Treasure             | ![Treasure][treasure] | Can be collected by the player. |
| Door                 | ![Door][door_open] ![Door][door_closed] | Exists in conjunction with a single key that can open it. If the player holds the key, they can open the door by moving through it. Once open it remains so. The client will be satisfied if dungeons can be made with up to 3 doors. |
| Key                  | ![Key][key] | Can be picked up by the player when they move into the square containing it. The player can carry only one key at a time, and only one door has a lock that fits the key. It disappears once it is used to open its corresponding door. |
| Boulder              | ![Boulder][boulder] | Acts like a wall in most cases. The only difference being that it can be pushed by the player into adjacent squares. The player is only strong enough to push **one** boulder at a time. |
| Floor switch         | ![Floor switch][switch] | Switches behave like empty squares, so other entities can appear on top of them. When a boulder is pushed onto a floor switch, it is triggered. Pushing a boulder off the floor switch untriggers it. |
| Portal               | ![Portal][portal] | Teleports entities to a corresponding portal. |
| Enemy                | ![Enemy][enemy] | Constantly moves toward the player, stopping if it cannot move any closer. The player dies upon collision with an enemy. |
| Sword                | ![Sword][sword] | This can be picked up the player and used to kill enemies. Only one sword can be carried at once. Each sword is only capable of 5 hits and disappears after that. One hit of the sword is sufficient to destroy any enemy. |
| Invincibility potion | ![Invincibility][invincibility] | If the player picks this up they become invincible to enemies. Colliding with an enemy should result in their immediate destruction. Because of this, all enemies will run away from the player when they are invincible. The effect of the potion only lasts a limited time. |

### Goals

In addition to its layout, each dungeon also has a goal that defines what must be achieved by the player for the dungeon to be considered complete. Basic goals are:

* Getting to an exit.
* Destroying all enemies.
* Having a boulder on all floor switches.
* Collecting all treasure.

More complex goals can be built by logically composing goals. For example,

* Destroying all enemies AND getting to an exit
* Collecting all treasure OR having a boulder on all floor switches
* Getting to an exit AND (destroying all enemies OR collecting all treasure)

If getting to an exit is one of a conjunction of conditions, it must be done last. For example, if the condition is to destroy all enemies AND get to an exit, the player must destroy the enemies *then* get to the exit.


### User interface

The UI component of this project is implemented in JavaFX. 

## Requirement analysis (Milestone 1)

You are expected to produce:

1. High-level epic stories from the problem statement. Each epic should have its own card/issue and a corresponding tag used to mark user stories that fall under it.
2. User stories, each containing:
   * a short description of the feature based on the Role-Goal-Benefit (or Role-Feature-Reason) template (Refer to the RGB model from COMP1531 if unsure)
   * an estimate for the implementation of the user story in user story points (e.g. 4 points).
   * a tag indicating the priority
   * acceptance criteria for each user story as a checklist in the issue (Refer to material from COMP1531 if unsure)



## Domain modelling and backend implementation (Milestone 2)

Based on your requirements analysis, we've produced a domain model for the backend component of the project in the form of a conceptual UML class diagram.




### Milestone 1

| Criteria | Mark  |                                                                                                  |
|:-------- |:----- |:------------------------------------------------------------------------------------------------ |
| Stories  | 0     | No user stories                                                                                  |
|          | 1     | User and epic stories not in a valid format and/or vague or ambiguous                            |
|          | 2     | Some user or epic stories not in a valid format and/or vague or ambiguous                        |
|          | 3     | User and epic stories in a valid format, but with unclear benefits, goals or acceptance criteria |
|          | 4     | Significant majority of user stories unambiguous and clear, with concrete acceptance criteria    |
|          | 5     | Unambiguous and clear user stories with concrete acceptance criteria                             |
| Planning | 0     | No user stories have points or priorities                                                        |
|          | 1     | Only some user stories have points or priorities                                                 |
|          | 2     | User stories have appropriate story point values and priorities                                  |

### Milestone 2

| Criteria     | Mark |                                                                                                   |
|:------------ |:---- |:------------------------------------------------------------------------------------------------- |
| Completeness | 0    | No or largely incomplete backend                                                                  |
|              | 1    | Backend implements some of the entities                                                           |
|              | 2    | Backend implements most of the entities                                                           |
|              | 3    | Backend implements almost all entities                                                            |
|              | 4    | Backend implements all of the entities                                                            |
| Testing      | 0    | No JUnit tests                                                                                    |
|              | 1    | JUnit tests for behaviour of a few entities                                                       |
|              | 2    | Rigorous JUnit tests for behaviour of almost all entities                                         |
|              | 3    | Rigorous JUnit tests for behaviour of all entities                                                |
| Design       | 0    | No apparent consideration for design                                                              |
|              | 1    | Messy design and diagrams and/or design inconsistent with code                                    |
|              | 2    | Clear design and diagrams with partial adherence to design principles and patterns                |
|              | 3    | Clear design and diagrams with strong adherence to design principles and patterns                 |
|              | 4    | Clear design and diagrams fully adhering to design principles and patterns and conforming to code |

Marks will be deducted for poor git and GitLab usage. For example, meaningless commit messages, large commits, issue board out of date, etc.

### Milestone 3

| Criteria     | Mark |                                                                                                   |
|:------------ |:---- |:------------------------------------------------------------------------------------------------- |
| Completeness | 0    | No or largely incomplete project                                                                  |
|              | 1    | Dungeons can be played with most of the entities                                                  |
|              | 2    | Dungeons can be played with almost all of the entities                                            |
|              | 3    | Dungeons can be played with all of the entities                                                   |
| Design       | 0    | No apparent consideration for design                                                              |
|              | 1    | Messy design and diagrams and/or design inconsistent with code                                    |
|              | 2    | Messy diagrams and/or poor application of design patterns                                         |
|              | 3    | Moderately clear diagrams and moderate application of design patterns                             |
|              | 4    | Clear design and diagrams with moderate adherence to design principles and patterns               |
|              | 5    | Clear design and diagrams with strong adherence to design principles and patterns                 |
|              | 6    | Clear design and diagrams fully adhering to design principles and conforming to code, and correct application of design patterns |
| Interaction  | 0    | Very basic user interface                                                                         |
|              | 1    | Interface that makes it possible to solve dungeons, but is slow, awkward, or buggy                |
|              | 2    | An interface that is mostly usable but with little consideration for usability heuristics         |
|              | 3    | Interface that is easy to use                                                                     |
|              | 4    | Interface that is easy and intuitive to use                                                       |
|              | 5    | A product that is engaging, intuitive and fun to use                                              |
| Extensions   | 0    | No extensions or only very basic extensions                                                       |
|              | 1    | One extension that represents some technical consideration                                        |
|              | 2    | Two extensions representing some technical consideration                                          |
|              | 3    | Three or more extensions that represent some technical as well as design and user interaction consideration |

Marks will be deducted for poor git and GitLab usage. For example, meaningless commit messages, large commits, issue board out of date, etc.

[player]:        images/human_new.png
[wall]:          images/brick_brown_0.png
[exit]:          images/exit.png
[door_open]:     images/open_door.png
[door_closed]:   images/closed_door.png
[key]:           images/key.png
[boulder]:       images/boulder.png
[switch]:        images/pressure_plate.png
[portal]:        images/portal.png
[enemy]:         images/deep_elf_master_archer.png
[sword]:         images/greatsword_1_new.png
[invincibility]: images/brilliant_blue_new.png
[treasure]:      images/gold_pile.png

[maze]:          examples/maze.png
[boulders]:      examples/boulders.png
[advanced]:      examples/advanced.png


# Yahtzee Game

This project is a Java implementation of the popular dice game "Yahtzee." It focuses on computing scores based on the values of the dice, just like in the traditional board game.

## Table of Contents
- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Running the Game](#running-the-game)
- [Tests](#tests)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

Yahtzee is a popular family game involving 5 dice and a scorepad. On a player's turn, they roll the 5 dice, choose to re-roll any number of them, and then decide which scoring category to apply. The goal is to maximize the score based on various scoring categories, including Aces, Twos, Threes, 3 of a kind, 4 of a kind, Full House, Small Straight, Large Straight, Yahtzee, and Chance.

This project provides Java classes to simulate the game, calculate scores, and test the game's functionality.

## Project Structure

The project is organized into the following files:

- `Yahtzee.java`: The main class representing the Yahtzee game and scoring logic.
- `Dice.java`: A class representing a single six-sided dice.
- `RandomNumber.java`: A utility class to generate random numbers.
- `TestGame.java`: A class containing test cases to verify the functionality of the Yahtzee game.

## Getting Started

### Prerequisites

To run the Yahtzee game, you need the following:

- Java Development Kit (JDK) installed on your computer.

### Installation

1. Clone this repository to your local machine:

   ```sh
   git clone <repository-url>

## Usage

### Running the Game

You can run the Yahtzee game by creating instances of the Yahtzee class, providing dice values, and calculating scores. Here's a simple example:

```java
public static void main(String[] args) {
    Yahtzee game = new Yahtzee(new Dice[] {new Dice(1), new Dice(2), new Dice(3), new Dice(4), new Dice(5)});
    System.out.println("Dice: " + game.toString());
    int[] scores = game.getScoreOptions();
    System.out.println("Scores: " + Arrays.toString(scores));
}

## Tests

The project includes a set of test cases in TestGame.java to ensure the correctness of the Yahtzee game implementation. You can run these tests to verify the behavior of the game.

To run the tests, execute the following command:

```sh
java TestGame

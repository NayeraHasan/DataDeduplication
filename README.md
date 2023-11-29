# Data-Deduplication-Hash-Tables-and-Deduplication-Algorithms

This project focuses on data deduplication using three specific methods: All pairs, Linear hashing, and Sort-remove. The Java-based implementation aims to efficiently identify and remove duplicate voter records from a dataset as well as analyzing the efficiency of each method in terms of time and memory usage using principles of Object-Oriented Programming (OOP).

## Table of Contents
- [Overview](#overview)
- [Data Source: Voting Rolls](#data-source-voting-rolls)
- [Classes](#classes)
  - [Voter Class](#voter-class)
  - [VoterDeduplication Class](#voterdeduplication-class)
  - [Main Class](#main-class)


## Overview

The project's core objectives are:

- Processing voter roll data to instantiate Voter objects.
- Implementing and evaluating three specific deduplication methods: All pairs, Linear hashing, and Sort-remove.
- Analyzing the efficiency of each deduplication method in terms of time and memory usage, providing insights into the trade-offs involved in data deduplication.
  
## Input: Voting Rolls
The dataset represents registered voters in the United States, specifically focusing on the Ohio statewide voter rolls. The data is structured in CSV format. The CSV format includes voterID, countyNumber, countyID, lastName, firstName, middleName, suffix, birthdate, and other voting information. Only the lastName, firstName, middleName, and birthdate columns are essential.

## Classes

### Voter Class

**Attributes**: 
- First name
- Middle name
- Last name
- Birthday

**Methods**:
- `getFirstName()`: Returns the voter's first name.
- `setFirstName(String firstName)`: Sets the voter's first name.
- `getMiddleName()`: Returns the voter's middle name.
- `setMiddleName(String middleName)`: Sets the voter's middle name.
- `getLastName()`: Returns the voter's last name.
- `setLastName(String lastName)`: Sets the voter's last name.
- `getBirthdate()`: Returns the voter's birthdate.
- `setBirthdate(String birthdate)`: Sets the voter's birthdate.
- `compareTo(Voter other)`: Compares two Voter objects.
- `toString()`: Returns a string representation of the voter.

### VoterDeduplication Class

**Attributes**: 
- Original voter dataset (ArrayList)
- Deduplicated dataset (ArrayList)

**Methods**:
- `allPairsDeduplication()`: Deduplicates using the all pairs method.
- `sortAndRemoveDeduplication()`: Deduplicates using the sort and remove method.
- `hashMapDeduplication()`: Deduplicates using a HashMap.
- `getDeduplicateVoters()`: Returns the deduplicated list of voters.
- `getOriginalVoters()`: Returns the original list of voters.

### Main Class

**Functionality**: 
- Reads the dataset.
- Initializes the VoterDeduplication object.
- Applies all deduplication methods sequentially.
- Computes and presents performance metrics.

**Methods**:
- `main(String[] args)`: Main method to run the program.



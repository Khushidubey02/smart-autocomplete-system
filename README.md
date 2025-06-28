# Smart Autocomplete System

This project implements an autocomplete feature using Trie data structure. As the user types a prefix, it suggests words that start with that prefix.

## What I Learned
- Trie data structure
- How to store words with frequency
- Using PriorityQueue to sort suggestions

## Tech Stack
- Java
- Trie
- HashMap
- PriorityQueue

## How it works
- Insert sentences with their frequency into the Trie
- On every character input, traverse the Trie and return top suggestions based on frequency

## Example
Input: ["hello", "help", "hey", "hello"]  
Typing "he" → Output: ["hello", "help", "hey"]

# Text Formatter
Input text and transform its format using various formatters. You can shuffle, repeat, move and hash letters at once with formatters with key(argument) when needed.
```
1. shuffle "apple" -> "epapl"
2. shuffle and repeat twice "apple" -> "epaplepapl"
3. shuffle, repeat and move to right once "apple" -> "lepaplepap"
4. shuffle, repeat, move and hash "apple" -> "GNOA0jgHg1H1R8aMxu1prCsXKhFpcp2GoUt64NxQD1c="
```

# Quick start
Come to [discord](https://discord.gg/rbbaKCYt74) and run this command: `/format <text> [formatters] [keys]`

---

Or use `CommandExecutor` created by factory and execute with input format: `<text>/<formatters>/<keys>`
```java
CommandExecutor executor = new NormalCommandExecutorFactory().create();
System.out.println(executor.execute("abcde/m/2")); // deabc
```
---
**Or** you can use a simple command line interpreter by running [TextFormatterCmdApp.java](src/io/textformatter/cmd/TextFormatterCmdApp.java) (Type `help` for commands)
```
> format abcde/m/2

---------------------------------
Text: abcde
Formatters: m
Keys: 2
Result: deabc
---------------------------------
```

# Formatters
Examples format: `<text>/<formatters>/<keys> -> <result>`
- [Caesar](#caesar)
- [Delete](#delete)
- [Expression](#expression)
- [First](#first)
- [Hash](#hash)
- [Insert](#insert)
- [Join](#join)
- [Last](#last)
- [Move](#move)
- [Parser](#parser)
- [Random](#random)
- [Stupid](#stupid)
- [Times](#times)
- [Xor](#xor)
- [Replace](#replace)
- [Reverse](#reverse)
- [Shuffle](#shuffle)



### Caesar
- Name: `c`
- Key: `<count>`

Shift the letters of the key (known as shift or caesar cipher).
```
abcde/c/3 -> defgh
abcde/c/-1 -> zabcd
```



### Delete
- Name: `d`
- Key: `<start>,<end>`

Delete the letters between the keys.
```
abcde/d/2,4 -> ae
abcde/d/-3,-1 -> ab
```



### Expression
- Name: `e`
- Key: `[<expression>]`

Evaluate expression at the key which is surrounded by brackets.
Take a look [here](https://github.com/Redempt/Crunch#operations-and-syntax) to find more math symbols. (Using [Crunch](https://github.com/Redempt/Crunch) library)
```
1+1=/el/[1+1] -> 1+1=2
3*1.5=/el/[3*1.5] -> 3*1.5=4.5
e=/el/[e] -> e=2.718281828459045
floor of 0.6=/el/[floor(0.6)] -> floor of 0.6=0
```



### First
- Name: `f`
- Key: `Not required`

Append the key letters to head of the text.
```
 is a apple/f/This  -> This is a apple
```



### Hash
- Name: `h`
- Key: `Not required`

Get a digest using SHA-256 hash function.
```
abcde/h -> NrvlDtloQdEEQ7y2cNZVTwo0t2G+Z+ycSorSwMRMpCw=
```



### Insert
- Name: `i`
- Key: `<index>,<letters>`

Insert specific letter into somewhere you want.
```
This  a apple/i/5,is -> This is a apple
```



### Join
- Name: `j`
- Key: `Not required`

Insert the key letter between of the all text letters.
```
abcde/j/, -> a,b,c,d,e
```



### Last
- Name: `l`
- Key: `Not required`

Append the key letters to the end of the text.
```
This is a /l/apple -> This is a apple
```



### Move
- Name: `m`
- Key: `<count>`

Move text to right if the key is positive or left if negative.
```
abcde/m/1 -> eabcd
abcde/m/-2 -> cdeab
```



### Par$er
- Name: `$`
- Key: `{len} | {<start>,<end>}`

Replace the key with pre-defined values.
```
abcde/$l/{len} -> abcde5
abcde/$l/{1,3} -> abcdeabc
abcde/$l/{-2,-1} -> abcdede
abcde/$l/{3,{len}} -> abcdecde
```



### Random
- Name: `?`
- Key: `Not required`

Change letters randomly (numbers will be changed to random numbers).
```
abcde/?/ -> VKoJU
abc123/?/ -> hSb562
```



### Stupid
- Name: `u`
- Key: `Not required`

Make uppercase or lowercase randomly.
```
abcde/u/ -> ABcDe
```



### Times
- Name: `t`
- Key: `count`

Repeat the text with the given key times.
```
abcde/t/3 -> abcdeabcdeabcde
abcde/t/1.5 -> abcdeab
```



### Xor
- Name: `x`
- Key: `anything`

Do XOR the text as bytes with a key bytes.
(flag `§` is added when text is encrypted, and it will be removed when being decrypted)
```
abcde/x/alphabet -> §AA4TDAQ=
§AA4TDAQ=/x/alphabet -> abcde
```



### Replace
- Name: `r`
- Key: `<old> > <new>`

Replace the target text with a new letters.
```
abcde/r/c>C -> abCde
abcde/r/bcd> -> ae
format a b c d e/r/ > -> abcde
```



### Reverse
- Name: `v`
- Key: `Not required`

Reverse the text.
```
abcde/v/ -> edcba
```



### Shuffle
- Name: `s`
- Key: `Not required`

Shuffle letters.
```
abcde/s/ -> bcdea
```



# Quiz
Figure out `Text`, `Formatters`, `Keys` and `Result` that is/are not appeared in the quiz box.

---

### 1
```
Formatters: m
Keys: 3
Result: llohe
```
<details>
  <summary>Answer (Click me)</summary>

Try `llohe/m/-3`
```
Text: hello
```
</details>

---

### 2
```
Text: what
Formatters: c
Keys: 1
```
<details>
  <summary>Answer (Click me)</summary>

```
Result: xibu
```
</details>

---

### 3
```
Formatters: x
Keys: apple
Result: §CRUcAApBBBgJFwQ=
```
<details>
  <summary>Answer (Click me)</summary>

Try `§CRUcAApBBBgJFwQ=/x/apple`
```
Text: hello there
```
</details>

---

### 4
```
Formatters: mc
Keys: 2:4
Result: v8ryqfi
```
<details>
  <summary>Answer (Click me)</summary>

Try `v8ryqfi/cm/-4:-2`
```
Text: number4
```
</details>

---

### 5
```
Formatters: rcx
Keys: t>z:9:text
Result: §NwsfHVQqABUCDxEdGgQ=
```
<details>
  <summary>Answer (Click me)</summary>

Try `§NwsfHVQqABUCDxEdGgQ=/xcr/text:-9:z>t`
```
Text: Text Formatter
```
</details>


<!--
### 4
```

```
<details>
  <summary>Answer (Click me)</summary>

```

```
</details>
-->


# Usage
### 1. Create formatters
Create a `NormalFormatter` referencing `TextFormatter` interface first and wrap it with other formatters you want. Note
that text will be processed in reverse of the wrapped formatter order.

> `TextFormatter` is using [decorator](https://en.wikipedia.org/wiki/Decorator_pattern) pattern to transform the text continuously.

```java
// need normal formatter by default
TextFormatter formatter = new NormalFormatter();
formatter = new TimesFormatter(formatter); // repeat the text n times
formatter = new MoveFormatter(formatter); // move the text to right side
```

### 2. Input text and key
After created the formatter, all you need to do is just input your text and key to the
wrapped `formatter#format(text, key)`. Key will be used the left side first. (key delimiter is `:` by default)

```java
String text = "abcde";
String key = "1:2";
String result = formatter.format(text, key);
System.out.println(result);
```
The result will be `eabcdeabcd` (reversed first, and repeated 3 times).



# Notes
Using [Crunch](https://github.com/Redempt/Crunch) in `ExpressionFormatter` to
evaluate expressions. (Containing all source code)



# License
MIT


[//]: # (# TODO)
[//]: # (- write javadoc of all formatters)
[//]: # (- Make simple website to run command)
[//]: # (- exception handling or all formatters)

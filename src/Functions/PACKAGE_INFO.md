#Functions

This package provides a series of classes related to functions.  

## Basic structure

### Values
Every `Value` can be evaluated to a BigDecimal.
Values can be simple, such as `5`, or more complicated,
such as `Cos(Multiply(5, Divide(X, 7)))`.
Regardless of how the Values are structured,
they all have one thing in common: they can be evaluated using
`getValue()`.

### Functions
Functions are simply a wrapper for a `Value`.
They contain a single value and have methods related to functions.
Functions are an instance of `Value`, so they can also be evaluated.

### Modifiers
Modifiers are also an instance of `Value`.
These will contain one or more values, such as `5`.
They, when evaluated, return the `Value` inside, but modified.
For example, `Add` stores two `Value` objects.
When `getValue()` is called on that `Add`,
The sum of the two `Value` objects contained is returned.
## SELECT and WHERE
- The clauses always need to be in this order: `SELECT`, `FROM`, `WHERE`.

## Comparison Operators
- SQL uses **single quotes** to reference column values. If you're using an operator with values that are non-numeric, you need to put the value in single quotes: `'value'`.

Example #1: 
```
SELECT *
  FROM tutorial.us_housing_units
  WHERE month_name > 'January'
```
The month_name will be words that list after 'January' in a real dictionary.

Example #2: 
```
SELECT *
  FROM tutorial.us_housing_units
  WHERE month_name > 'january'
```
The month_name will be words that list after 'january' ('January' will be included!!) in a real dictionary.

Example #3: 
```
SELECT *
  FROM tutorial.us_housing_units
 WHERE month_name > 'J'
```
The month_name will be words that list after letter 'J' ('January' will also be included!!) in a real dictionary.

- Arithmetic operating in `SELECT`: **Can only use for numeric values!**

Example #1:
```
SELECT year,
       month,
       west,
       south,
       west + south - 4 * year AS nonsense_column
  FROM tutorial.us_housing_units
```

## 

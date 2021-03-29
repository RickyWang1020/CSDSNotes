# Basics

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

## LIKE
- Wildcard (`%`): represents any characters or set of characters.

Example #1:
```
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE "group" LIKE 'Snoop%'
```
Since `GROUP` is the name of a function, we use double quote to indicate that the `"group"` is a column name in dataset

- A tip: `LIKE '%wantedword%'` can used for searching all rows where the wanted word is within it

- `LIKE` is **case-sensitive**. To ignore case, use `ILIKE`.

Example #2: 
```
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE "group" ILIKE 'snoop%'
```

- Can also use single underscore - "\_", to substitute for a character.

Example #3: 
```
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE "group" ILIKE 'dr_ke'
```

## IN
Example #1:
```
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE year_rank IN (1, 2, 3)
```

Example #2:
```
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE artist IN ('Taylor Swift', 'Usher', 'Ludacris')
```

## BETWEEN

The following codes have the same effect (`BETWEEN` is a closed interval):
```
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE year_rank BETWEEN 5 AND 10
```

```
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE year_rank >= 5 AND year_rank <= 10
```

## NOT, AND, OR

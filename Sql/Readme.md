# Basics

## SELECT and WHERE
- The clauses always need to be in this order: `SELECT`, `FROM`, `WHERE`.

## LIMIT and OFFSET
- LIMIT: the #of lines of data wanted to get
- OFFSET: the #of lines of data wanted to skip

## Comparison Operators
- SQL uses **single quotes** to reference column values. If you're using an operator with values that are non-numeric, you need to put the value in single quotes: `'value'`.

Example #1: 
```mysql
SELECT *
  FROM tutorial.us_housing_units
 WHERE month_name > 'January'
```
The month_name will be words that list after 'January' in a real dictionary.

Example #2: 
```mysql
SELECT *
  FROM tutorial.us_housing_units
 WHERE month_name > 'january'
```
The month_name will be words that list after 'january' ('January' will be included!!) in a real dictionary.

Example #3: 
```mysql
SELECT *
  FROM tutorial.us_housing_units
 WHERE month_name > 'J'
```
The month_name will be words that list after letter 'J' ('January' will also be included!!) in a real dictionary.

- Arithmetic operating in `SELECT`: **Can only use for numeric values!**

Example #1:
```mysql
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
```mysql
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE "group" LIKE 'Snoop%'
```
Since `GROUP` is the name of a function, we use double quote to indicate that the `"group"` is a column name in dataset

- A tip: `LIKE '%wantedword%'` can used for searching all rows where the wanted word is within it

- `LIKE` is **case-sensitive**. To ignore case, use `ILIKE`.

Example #2: 
```mysql
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE "group" ILIKE 'snoop%'
```

- Can also use single underscore - "\_", to substitute for a character.

Example #3: 
```mysql
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE "group" ILIKE 'dr_ke'
```

## IN
Example #1:
```mysql
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE year_rank IN (1, 2, 3)
```

Example #2:
```mysql
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE artist IN ('Taylor Swift', 'Usher', 'Ludacris')
```

## BETWEEN

The following codes have the same effect (`BETWEEN` is a closed interval):
```mysql
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE year_rank BETWEEN 5 AND 10
```

```mysql
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE year_rank >= 5 AND year_rank <= 10
```

## ORDER BY

- Default: ascending, if want descending, use `DESC`.

Example #1:
```mysql
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE year = 2013
 ORDER BY year_rank DESC
```
- Order by multiple columns: the `DESC` operator is only applied to the column that precedes it!

Example #2:
```mysql
-- year_rank ascending, year descending
SELECT *
  FROM tutorial.billboard_top_100_year_end
 WHERE year_rank <= 3
 ORDER BY year_rank, year DESC
```

- `ORDER BY` + `LIMIT`: ordering is executed first, then limit the result to a few rows

# Intermediate

## Aggregate Functions

- `COUNT`, `SUM`, `MIN`, `MAX`, `AVG`

## COUNT
- Basics:
```mysql
SELECT COUNT(*) FROM tutorial.aapl_historical_stock_price
-- is the same as 
SELECT COUNT(1) FROM tutorial.aapl_historical_stock_price
```
- Count an individual column
```mysql
SELECT COUNT(high) AS count_high
  FROM tutorial.aapl_historical_stock_price
```
This will return the # of **non-null** rows in "high"

## SUM (Only for numeric values)
Example #1: return the average
```mysql
SELECT SUM(open) / COUNT(open) AS avg_open
  FROM tutorial.aapl_historical_stock_price
```
The same effect as: (`AVG` will also ignore NULL values)
```mysql
SELECT AVG(open) AS avg_open
  FROM tutorial.aapl_historical_stock_price
```
## GROUP BY: separate data into groups, so that aggregation can be further applied

- Basics:

Example #1: count the number of entries for each year and month
```mysql
SELECT year,
       month,
       COUNT(*) AS count
  FROM tutorial.aapl_historical_stock_price
 GROUP BY year, month
```

- `GROUP BY` + `ORDER BY`
Example #2:
```mysql
SELECT year,
       month,
       SUM(volume) AS volume_sum
  FROM tutorial.aapl_historical_stock_price
 GROUP BY year, month
 ORDER BY year, month
```
Example #3: aggregate multiple functions
```mysql
SELECT year,
       month,
       MAX(high) AS max_val,
       MIN(low) AS min_val
   FROM tutorial.aapl_historical_stock_price
  GROUP BY year, month
  ORDER BY year, month
```

## HAVING: a clean way to filter an aggregated query

```mysql
SELECT year,
       month,
       MAX(high) AS month_high
  FROM tutorial.aapl_historical_stock_price
 GROUP BY year, month
 -- select the rows with such conditions in an aggregated query
 HAVING MAX(high) > 400
 ORDER BY year, month
```

## CASE: "if" statement

- Basics: `WHEN`, `THEN` and `END` (`ELSE` is optional)

```mysql
SELECT player_name,
       position,
       CASE WHEN position = 'WR' THEN 'yes'
            ELSE 'no' END AS is_wr
  FROM benn.college_football_players
```
The `CASE` statement will check whether the values in the "position" column is 'WR': if so, write 'yes' in "is_wr" column, if not, write 'no' in "is_wr" column

- Multiple conditions:

Example #1: categorize the weight, which is already a good approach (if-elif-else format)
```mysql
SELECT player_name,
       weight,
       CASE WHEN weight > 250 THEN 'over 250'
            WHEN weight > 200 THEN '201-250'
            WHEN weight > 175 THEN '176-200'
            ELSE '175 or under' END AS weight_group
  FROM benn.college_football_players
```
Example #2: same as before, but it creates no-overlapping (which may be confusing) categories
```mysql
SELECT player_name,
       weight,
       CASE WHEN weight > 250 THEN 'over 250'
            WHEN weight > 200 AND weight <= 250 THEN '201-250'
            WHEN weight > 175 AND weight <= 200 THEN '176-200'
            ELSE '175 or under' END AS weight_group
  FROM benn.college_football_players
```
- 

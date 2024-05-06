USE employees;
SELECT gender, COUNT(*) AS quantity
FROM employees
GROUP BY gender;
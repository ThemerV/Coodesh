USE employees;
SELECT gender, YEAR(hire_date) AS hire_date, YEAR(birth_date) AS birth_date, COUNT(DISTINCT emp_no) AS quantity
FROM employees
GROUP BY gender, YEAR(hire_date), YEAR(birth_date);
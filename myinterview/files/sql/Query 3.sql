USE employees;
SELECT e.gender,
	AVG(s.salary) AS media,
    MIN(s.salary) AS min,
    MAX(s.salary) AS max
FROM employees e
JOIN salaries s ON e.emp_no = s.emp_no
GROUP BY e.gender;
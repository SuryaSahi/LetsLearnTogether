SELECT Employees.name , EmployeeUNI.unique_id 
from Employees 
NATURAL LEFT JOIN EmployeeUNI;

# NATURAL JOIN returns rows where there is a match in both tables, while NATURAL LEFT JOIN returns all rows from the left table and the matched rows from the right table, filling with NULL for unmatched rows.
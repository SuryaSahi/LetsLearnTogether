SELECT Visits.customer_id , COUNT(Visits.visit_id) as count_no_trans 
from Visits LEFT JOIN Transactions on Visits.visit_id = Transactions.visit_id
where Transactions.visit_id is NULL 
GROUP BY Visits.customer_id ;

-- It performs a LEFT JOIN between Visits and Transactions tables on visit_id.
-- Filters out rows where no corresponding transaction exists (NULL in Transactions table).
-- Groups the result by customer_id and counts the number of such visits per customer.

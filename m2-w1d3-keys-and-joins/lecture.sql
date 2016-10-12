-- INNER JOINS

-- Show all the film titles each store has in inventory
select i.store_id, f.title 
from inventory i 
inner join film f on i.film_id=f.film_id;


-- Now let's make it a bit more presentable, and comprehensible by ordering the display by store number with titles in alphabetic order for each store
select i.store_id, f.title 
from inventory i 
inner join film f on i.film_id=f.film_id 
order by i.store_id, f.title;


-- Display the first and last name of the manager for each store
select s.store_id, sf.first_name, sf.last_name
from store s 
inner join staff sf on s.manager_staff_id=sf.staff_id;


-- Once again, make it a bit more presentable, by displaying the manager's full name with last name first, and the full names in descending order for no particular reason
select s.store_id, (sf.last_name||', '||sf.first_name) as full_name 
from store s 
inner join staff sf on s.manager_staff_id=sf.staff_id
order by full_name desc;


-- It sure would be nice to know where the stores are, so let's include the store's street address to the above query.  This introduces a three table join
select s.store_id, a.address, (sf.last_name||', '||sf.first_name) as full_name 
from store s 
inner join staff sf on s.manager_staff_id=sf.staff_id
inner join address a on s.address_id=a.address_id
order by full_name desc;


-- Another three table join involves showing all the films and their categories ordered by film title
select f.title, c.name 
from film f 
inner join film_category fc on f.film_id=fc.film_id 
inner join category c on c.category_id=fc.category_id 
order by f.title;


-- Show all the 'Comedy' films ordered by film title
select f.title, c.name 
from film f 
inner join film_category fc on f.film_id=fc.film_id 
inner join category c on c.category_id=fc.category_id 
where c.name='Comedy' 
order by f.title;


-- Finally, let's count the number of films under each category
select c.name, count(c.name) 
from film f 
inner join film_category fc on f.film_id=fc.film_id 
inner join category c on c.category_id=fc.category_id 
group by c.name 
order by c.name;



-- LEFT OUTER JOINS
-- Show all languages for which there are no film in that language 
select f.title, l.name 
from language l 
left outer join film f on l.language_id=f.language_id;


-- To narrow down what languages don't have films, add and IS NULL
select f.title, l.name 
from language l 
left outer join film f on l.language_id=f.language_id 
where f.title is null;



-- RIGHT OUTER JOINS
-- The following SQL yields the same result as the previous
select f.title, l.name 
from film f 
right outer join language l on l.language_id=f.language_id 
where f.title is null;

-- Recommendation is to pick LEFT or RIGHT as a personal preference, and then stick with it
-- This isn't to say that what table gets compared to the other doesn't matter, because it does.
-- Returning to original query, and switching to RIGHT, means the film table is compared to the language table, the the results are indeed different.
-- There are no films which have an unknown category, hence, no NULLs are displayed.
select f.title, l.name 
from language l 
right outer join film f on l.language_id=f.language_id;



-- UNIONS
-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates
select first_name from actor
union
select first_name from customer order by first_name;


-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer
select first_name, 'A' as source from actor
union
select first_name, 'C' as source from customer order by first_name;

-- Just for fun, count how many distict first names there are for actors, and how many for customers
select first_name, 'A' as source from actor
union
select first_name, 'C' as source from customer order by first_name;

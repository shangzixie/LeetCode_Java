Select distinct(*)
FROM bookings as b
JOIN listings as l on b.id_listing = l.id_listing
WHERE l.dim_country = 'US'
GROUP BY b.ds
ORDER BY b.ds
#!/bin/bash

# define key information
src=src/main/sql
dbname=aw_supermarket_checkout_development
dbuser=aw_supermarket_checkout
dbpassword="secret"

# no customization needed beyond this line

# Stop at the first error
set -e

# Go to the main project directory
cd "$(dirname $0)/.."


dropdb $dbname || true
createdb $dbname
dropuser $dbuser || true
createuser --no-superuser --createdb --no-createrole $dbuser


echo "ALTER USER $dbuser WITH PASSWORD '$dbpassword'" | psql $dbname
cat $src/???_*.sql $src/seed.sql | psql $dbname
echo "GRANT ALL PRIVILEGES ON TABLE products TO $dbuser " | psql $dbname

echo "OK"

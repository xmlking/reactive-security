#!/bin/bash
IFS=$(echo -en "\n\b")
TABLES=$(mdb-tables -1 $1)

mdb-schema --drop-table $1 mysql

for t in $TABLES
do
    mdb-export -I mysql $1 $t
done
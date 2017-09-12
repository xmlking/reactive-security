Access2MySQL
 ===========
 How to export access's .mdb schema, data to MySQL

### Install
> on mac
```bash
brew install mdbtools
```

### Export Schema
```bash
mdb-schema --drop-table MatMan.mdb mysql > schema.sql
```


### Export Data
```bash
./to_mysql_data.sh MatMan.mdb > data.sql
```

### Reference 
https://github.com/brianb/mdbtools/blob/master/doc/mdb-schema.txt
https://github.com/brianb/mdbtools/blob/master/doc/mdb-export.txt

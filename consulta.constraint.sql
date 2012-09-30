USE GTRANSITO;
select COLUMN_NAME, CONSTRAINT_NAME,REFERENCED_COLUMN_NAME 
from information_schema.key_column_usage
where TABLE_NAME = 'VEICULO' AND referenced_table_name is not null;

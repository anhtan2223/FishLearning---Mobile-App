select * from class ;
select * from user ;
select * from enrollment ;
select * from topic ;
select * from textbox ;
select * from document ;
select * from test ;
select * from question ;
select * from answer ;

select count(studentid) , classid from enrollment
group by classid 
with rollup ;

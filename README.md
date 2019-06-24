# karetis_project

 Time by every function :
 1. Batch Insertion: Insert rows by batch of 1000 = ~ 9 667s 000ms
 2. Bulk Insertion: Save in a csv file and then load infile to the sql database =  18s 426ms
 
 So the bulk insertion seems to be a good method to store a large amount of data in sql database

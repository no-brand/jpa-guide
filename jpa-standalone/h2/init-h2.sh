#!/bin/bash

#----------------------------------------------------------------#
# Driver Class | org.h2.Driver
# JDBC URL     | jdbc:h2:~/jpa-guide/jpa-standalone/h2/database
# Username     | admin
# Password     | admin
#----------------------------------------------------------------#
wget https://github.com/h2database/h2database/releases/download/version-2.1.212/h2-2022-04-09.zip ./h2-2022-04-09.zip
unzip h2-2022-04-09.zip
nohup sh ./h2/bin/h2.sh > h2.out &

#!/bin/sh
for ((i=0;i<20;i++))
do
	out=`head -200 /dev/urandom | cksum | cut -f1 -d " "`
	echo $out
#	echo $RANDOM
done



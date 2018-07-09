#!/bin/bash
read -p "press some key ,then press return :" KEY
case $KEY in
[a-z]|[A-Z])
echo "It's a letter."
;;
[0-9]) 
echo "It's a digit."
;;
*)
echo "It's function keys、Spacebar or other ksys."
esac
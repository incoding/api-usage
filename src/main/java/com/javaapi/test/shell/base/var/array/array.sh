#!/usr/bin/env bash
a=(1 2 3 4 5)
echo $a

echo "数组长度:"  ${#a[@]} "或"  ${#a[*]}

echo "echo ${a[2]}"

echo "echo ${a[@]},${a[*]}  "


 a[1]=100

echo ${a[*]}
echo '---------'

#
 a=(1 2 3 4 5)
 unset a
 echo ${a[*]}
 a=(1 2 3 4 5)
 unset a[1]
 echo ${a[*]}
 echo ${a[0]}
 echo ${a[1]}
 echo ${a[2]}

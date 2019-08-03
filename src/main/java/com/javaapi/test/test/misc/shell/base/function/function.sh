#!/usr/bin/env bash

fname(){
echo "$1"

echo "$2"

echo "$@"


echo $*   #参数被作为单个实体，不常用

return $2
}

fname 2 3 4
###########  #读取返回值
echo $?

##########
export -f fname #导出函数
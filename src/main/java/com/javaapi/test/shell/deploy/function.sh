#!/bin/bash
function install(){
mvn -B -U -e clean install
}
function package(){
mvn -B -U -e clean package 
}
function printinfo(){
echo "`pwd` deploying..."
}

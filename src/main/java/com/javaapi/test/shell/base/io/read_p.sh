#!/usr/bin/env bash
read -p "Enter your job title:"

echo "I thought you might be an $REPLY."

echo  "Who are your best friends? "

read -a friends

echo "Say hi to ${friends[2]}."
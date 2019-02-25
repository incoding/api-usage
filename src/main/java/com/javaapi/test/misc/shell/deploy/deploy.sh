#!/bin/sh
source function.sh
client=/media/kk/0008F11F0005071C/workspace_linux_kepler/filter-real/filter-client
common=/media/kk/0008F11F0005071C/workspace_linux_kepler/filter-real/filter-common
server=/media/kk/0008F11F0005071C/workspace_linux_kepler/filter-real/filter-service
web=/media/kk/0008F11F0005071C/workspace_linux_kepler/filter-real/filter-web

cd $common
install
printinfo
cd $client
printinfo 
install 

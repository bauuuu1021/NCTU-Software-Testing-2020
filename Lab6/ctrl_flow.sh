#!/bin/bash

clang -S -emit-llvm $1 -o _tmp.ll
FILE=".*.dot"
PNG=".png"

for f in $FILE
do
	opt --dot-cfg _tmp.ll
	set -f; IFS='.'
	set -- $f
	output="$2$PNG"
	set +f; unset IFS

	dot -Tpng $f -o $output

done

rm -rf  _tmp.ll  

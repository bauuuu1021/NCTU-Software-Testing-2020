#!/bin/sh

clang -S -emit-llvm $1 -o - | opt -analyze -std-link-opts -dot-callgraph
cat callgraph.dot | gawk '/external node/{id=$1} $1 != id' | dot -Tpng -o $2 
rm -f callgraph.dot

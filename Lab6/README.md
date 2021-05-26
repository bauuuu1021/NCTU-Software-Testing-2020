# Lab6 of NCTU SW Testing
a practice of generating call graph and control flow graph

## Usage
* Generate call graph
	```
	./call_graph.sh <C File> <target png file>
	```
* Generate control flow graph
	```
	./ctrl_flow.sh <C File>
	```
## Sample Output
* Callgraph

	![](0856101_callgraph.png)

* Control Flow Graph for `main()`

	![](0856101_cfg.main.png)

* Control Flow Graph for `A()`

	![](0856101_cfg.A.png)

* Control Flow Graph for `B()`

	![](0856101_cfg.B.png)

* Control Flow Graph for `C()`

	![](0856101_cfg.C.png)
## Reference
* [call graph](https://stackoverflow.com/questions/5373714/how-to-generate-a-calling-graph-for-c-code)
* [control flow graph](https://stackoverflow.com/questions/40563240/control-flow-graph-generator-for-code-in-c)

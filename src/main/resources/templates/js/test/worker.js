var num_workers = 10;
var items_per_worker = 1000000;

// start the workers
var result = 0;
var pending_workers = num_workers;
for (var i = 0; i < num_workers; i += 1) {
  var worker = new Worker('/acms/js/test/core.js');
  worker.postMessage(i * items_per_worker);
  worker.postMessage((i + 1) * items_per_worker);
  console.log(1);
  worker.onmessage = storeResult;
}

// handle the results
function storeResult(event) {
  result += event.data;
  pending_workers -= 1;
  if (pending_workers <= 0)
    postMessage(result); // finished!
}

self.onmessage = function (e) {
	  var uInt8Array = e.data;
	  postMessage('Inside worker.js: uInt8Array.toString() = ' + uInt8Array.toString());
	  postMessage('Inside worker.js: uInt8Array.byteLength = ' + uInt8Array.byteLength);
	  console.log(2);
	};
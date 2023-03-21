window.addEventListener("DOMContentLoaded", function () {
  // Fetch tags having class of hilightable
  const tagsHavingHighltCls = document.querySelectorAll(".hilightable");
  // Iterate over tags with class value of 'hilightable'
  for (let tag of tagsHavingHighltCls) {
    // Insert focus, blur events type to tags with class value of 'hilightable'
    for (const eachEvent of ["focus", "blur"]) {
         tag.addEventListener(eachEvent, function () {
            // Make the class highlight toggle
            tag.classList.toggle("highlight");
          }
        );
    }
  }

  // Fetch tags having class of required
  const tagsHavingReqClsVal = document.querySelectorAll(".required");

  // Create submit evenet handler for form
  document.getElementById("mainForm").addEventListener("submit", function addErrorCls(e) {
    // e = event
    // Iterate over tags with class value of 'required'
    for (const singleTag of tagsHavingReqClsVal) {
      // if input boxes with required class were left unfilled
      if (singleTag.value === "") {
        // insert error class
        singleTag.classList.add("error");
        // prevent submit of form
        e.preventDefault();
      }
    }
  });

  // Iterate over tags with class value of 'required'
  for (const singleTag of tagsHavingReqClsVal) {
    // Create event handler for input boxes with class value of 'required' for 'input' event
    singleTag.addEventListener("input", function () {
      // delete 'error' class by using remove() method
      singleTag.classList.remove("error");
    });
  }

  //  Add an event handler for the Clear form button that returns to default settings when pressed.
  document.querySelector("#clearButton").addEventListener("click", function (e) {
    // clear all fields
    document.getElementById("mainForm").reset();
    // Iterate over tags with class value of 'required'
    for (const singleTag of tagsHavingReqClsVal) {
      // delete 'error' class by using remove() method
      singleTag.classList.remove("error");
    }
  });
});

var allTasks = document.getElementById("tasks");
var newTask = document.getElementById("todoinput");
var addButton = document.getElementById("addtask");
var taskbox = document.getElementById("taskbox");


function addtask(){
    var taskName = newTask.value.trim();
    if(taskName=="") return;

    let newListItem = document.createElement("li");
    newListItem.classList.add("li");

    let checkbox = document.createElement("input");
    checkbox.type="checkbox";
    checkbox.style.marginLeft="10px";

    checkbox.addEventListener("change",()=>{
        if(checkbox.checked){
            newListItem.style.textDecoration="line-through";
            newListItem.style.color="#413e3e";
        }
        else{
            newListItem.style.textDecoration="none";
            newListItem.style.color="black";
        }
    });

    let taskLabel = document.createElement("span");
    taskLabel.textContent=taskName;

    let deleteButton =document.createElement("button");
    deleteButton.textContent="Delete";
    deleteButton.classList.add("deleteButton");

    deleteButton.addEventListener("click",()=>{
        newListItem.remove();
        if(allTasks.children.length == 0){
            let text = document.createElement("h2");
            text.id="no-task";
            text.style.fontFamily="sans-serif";
            text.textContent="Sorry, You have no tasks in your To-Do List.";
            taskbox.appendChild(text);
        }
    });

    newListItem.appendChild(checkbox);
    newListItem.appendChild(taskLabel);
    newListItem.appendChild(deleteButton);

    allTasks.appendChild(newListItem);
    newTask.value="";

    if(taskbox.contains(document.getElementById("no-task"))){
        taskbox.removeChild(document.getElementById("no-task"));
    }

}


newTask.addEventListener('keypress',(e)=>{
    if(e.key=="Enter") addtask();
})
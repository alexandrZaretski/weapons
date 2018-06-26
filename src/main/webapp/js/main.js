function setSendAction() {
    var checkBoxes = document.getElementsByName("selectedContacts");
    var form = document.getElementById('main-form');
    var i;
    var flag = false;

    for(i=0; i < checkBoxes.length; i++){
        if(checkBoxes[i].checked){
            flag = true;
            break;
        }
    }
    if(!flag){
        alert("No select contacts!");
        return;
    }

    form.action='/main/send_email?isSend=false';
    form.submit();
}

function setDeleteAction(act) {
    var form = document.getElementById('main-form');
    var checkBoxes = document.getElementsByName("selectedContacts");
    var i;
    var flag = false;

    for(i=0; i < checkBoxes.length; i++){
        if(checkBoxes[i].checked){
            flag = true;
            break;
        }
    }
    if(!flag){
        alert("No select contacts!");
        return;
    }
    if(act === true){
        form.action='/main/delete?search=true';
    } else{
        form.action='/main/delete';
    }


    if(confirm('Are you sure?')){
        form.submit();
    }
}
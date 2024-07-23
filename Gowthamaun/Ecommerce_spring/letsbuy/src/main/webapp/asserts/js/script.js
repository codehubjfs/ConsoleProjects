
class Customer{
    constructor(username,firstname,lastname,address,mobileNumber,emailId,gender,accountStatus){
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.gender = gender;
        this.accountStatus = accountStatus;
        console.log('iofjo');
    }
}

class Vendor {
    constructor(username, address, mobileNumber, emailId, aadharNumber, accountStatus) {
        this.username = username;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.aadharNumber = aadharNumber;
        this.accountStatus = accountStatus;
    }
}

class Product {
    constructor(name, brand, price, stockStatus, vendorName,description,specification, verifiedStatus,categoryName,subCategoryName) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stockStatus = stockStatus;
        this.vendorName = vendorName;
        this.description = description;
        this.specification = specification;
        this.verifiedStatus = verifiedStatus;
        this.categoryName = categoryName;
        this.subCategoryName = subCategoryName;
     }
}


function openEditModal(name, status) {
    document.getElementById('editCustomerName').value = name;
    document.getElementById('editStatus').value = status;
    var editModal = new bootstrap.Modal(document.getElementById('editModal'));
    editModal.show();
}

function openViewModal(id, categoryName,status) {
    document.getElementById('viewCategoryId').innerText = id;
    document.getElementById('viewCategoryName').innerText = categoryName;
    document.getElementById('viewStatus').innerText = status;
    var viewModal = new bootstrap.Modal(document.getElementById('viewModal'));
    viewModal.show();
}

function openDeleteModal(id) {
    document.getElementById('deleteCategoryId').innerText = id;
    var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
    deleteModal.show();
}

function addDataModal(){
    var addModal = new bootstrap.Modal(document.getElementById('addModal'));
    addModal.show();
}


// The code for the sub-category modals//
function openSubCategoryViewModal(id,categoryName,subCategoryName,status){
    document.getElementById('viewSubCategoryId').innerHTML = id;
    document.getElementById('viewSubCategoryName').innerHTML = subCategoryName;
    document.getElementById('viewCategoryName').innerHTML = categoryName;
    document.getElementById('viewStatus').innerHTML = status;
    var viewModal = new bootstrap.Modal(document.getElementById('viewModal'));
    viewModal.show();
}

function viewCustomerDetail(customer){
    document.getElementById('cususerName').innerHTML=customer.username;
    console.log(customer.username);
    // document.getElementById('cususerName').innerHTML = customer.username;
            document.getElementById('cusFname').innerHTML = customer.firstname;
            document.getElementById('cusLname').innerHTML = customer.lastname;
            document.getElementById('cusaddress').innerHTML = customer.address;
            document.getElementById('cusMobileNumber').innerHTML = customer.mobileNumber.value;
            document.getElementById('cusEmailId').innerHTML = customer.emailId;
            document.getElementById('cusGender').innerHTML = customer.gender;
            document.getElementById('cusAccountstatus').innerHTML = customer.accountStatus;

            let viewModal = new bootstrap.Modal(document.getElementById('customerModal'));
            viewModal.show();
}



// function openSubCategoryEditModal(categoryName,subCategoryName,status){
//     document.getElementById('editSubCategoryName').value = subCategoryName;
//     document.getElementById('editCategoryName').value = categoryName;
//     document.getElementById('editStatus').value = status;
//     var editModal = new bootstrap.Modal(document.getElementById('editModal'));
//     editModal.show();
// }


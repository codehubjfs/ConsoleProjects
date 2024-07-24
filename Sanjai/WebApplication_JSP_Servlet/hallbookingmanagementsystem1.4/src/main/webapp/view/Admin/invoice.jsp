<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <link rel="icon" type="image/x-icon" href="image/LogoFavIcon.jpg">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assert/css/AdminStyle.css"/>
  <title>Golden Plaza - Invoice</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,300,300italic,400italic,700,700italic" rel="stylesheet">
  <style>
    body {
      background: #4e4332;
      font-family: 'Lato', 'Helvetica Neue', Helvetica, Arial, sans-serif;
      color: #333447;
    }
    h1, h2, h3, h4, h5, h6, p {
      margin: 0 0 10px;
      font-weight: normal;
    }
    .invoice-box {
      background: #ffffff;
      max-width: 900px;
      margin: 60px auto;
      padding: 30px;
      border: 1px solid #002336;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
      color: #002336;
    }
    .title {
      margin-bottom: 0;
      font-weight: bold;
      border-bottom: 1px solid #8B8B8B;
      padding-bottom: 4px;
      color: #4e4332;
    }
    .titles {
      background: #DCDCDC;
      font-weight: bold;
      color: #4e4332;
    }
    .item:nth-of-type(odd) {
      background: #F9F9F9;
    }
    .item:nth-of-type(even) {
      background: #fff;
    }
    .text-purple {
      color: #4e4332;
    }
    .btn-download {
      background-color: #4e4332;
      color: #fff;
      border: none;
    }
  </style>
</head>
<body>


  <div class="invoice-box" id="invoice">
    <div class="container">
      <div class="row mb-4">
        <div class="col-4 text-center">
          <a href="#"><img src="image/Logo.1.1.png" class="img-fluid" style="max-width: 160px;"></a>
        </div>
        <div class="col-4 text-center">
          <span id="AccountEmail">goldenplaza@support.com</span><br>
          <span id="AccountPhone">9876543210</span>
        </div>
        <div class="col-4 text-right">
          <h2 id="InvoiceSumExVat" class="mb-0">Golden Plaza</h2>
        </div>
      </div>
      <div class="row mb-4">
        <div class="col-4 title">
          To
        </div>
        <div class="col-4 title">
          From
        </div>
        <div class="col-4 title">
          Invoice Details<span class="float-right">#<span id="InvoiceNumber">99993</span></span>
        </div>
      </div>
      <div class="row mb-4">
        <div class="col-4">
          <span id="CustomerName">John Doe</span><br>
          <span id="CustomerAddress">123 Main Street</span><br>
          <span id="CustomerPostalCode">10001</span>, <span id="CustomerCity">New York</span><br>
          <span id="CustomerCountry">USA</span><br>
          <span id="CustomerRef">CustomerRef</span><br>
          <span id="CustomerProject">CustomerProject</span>
        </div>
        <div class="col-4">
          <span id="AccountName">Golden Plaza</span><br>
          <span id="AccountAddress">456 Elm Street</span><br>
          <span id="AccountPostalCode">10002</span>, <span id="AccountCity">New York</span><br>
          <span id="AccountCountry">USA</span><br>
          <span id="AccountRef">AccountRef</span><br>
          <span id="AccountProject">AccountProject</span>
        </div>
        <div class="col-4">
          <span>Issue Date:</span> <span class="float-right" id="CreatedDate">21. January 2024</span><br>
          <span>Due Date:</span> <span class="float-right" id="DueDate">10. February 2024</span><br>
          <span>Invoice Number:</span> <span class="float-right" id="InvoiceNumber">0000374334</span><br>
          <span>Bank Account:</span> <span class="float-right" id="InvoiceBankAccount">1503 44 06941</span><br>
          <span>IBAN:</span> <span class="float-right" id="InvoiceIban">DE89 3704 0044 0532 0130 00</span>
        </div>
      </div>
      <table class="table table-bordered">
        <thead class="titles">
          <tr>
            <th>Name</th>
            <th>Hall Name</th>
            <th>Booked Date</th>
            <th>Seating Arrangement</th>
            <th>Event</th>
            <th>Price</th>
            <th>Total (excl. VAT)</th>
          </tr>
        </thead>
        <tbody>
          <tr class="item">
            <td>John Doe</td>
            <td>Vertical Garden</td>
            <td>12/06/2024</td>
            <td>Theater Style</td>
            <td>Wedding Reception</td>
            <td>5000 USD</td>
            <td>5000 USD</td>
          </tr>
          <tr class="item">
            <td>John Doe</td>
            <td>Grand Hall</td>
            <td>15/06/2024</td>
            <td>Banquet Style</td>
            <td>Corporate Event</td>
            <td>7500 USD</td>
            <td>7500 USD</td>
          </tr>
          <tr class="item">
            <td>John Doe</td>
            <td>Rooftop Terrace</td>
            <td>18/06/2024</td>
            <td>Classroom Style</td>
            <td>Seminar</td>
            <td>4000 USD</td>
            <td>4000 USD</td>
          </tr>
          <tr class="item">
            <td>John Doe</td>
            <td>Conference Room</td>
            <td>20/06/2024</td>
            <td>U-Shape</td>
            <td>Business Meeting</td>
            <td>3000 USD</td>
            <td>3000 USD</td>
          </tr>
        </tbody>
      </table>
      <div class="row">
        <div class="col-12">
          <table class="table table-borderless">
            <tr>
              <td><strong>Total VAT:</strong></td>
              <td><span id="InvoiceTotalVat">2000</span> USD</td>
            </tr>
            <tr>
              <td><strong>Total (excl. VAT):</strong></td>
              <td><span id="InvoiceSumExVat">19500</span> USD</td>
            </tr>
            <tr>
              <td><strong>Total Amount Due:</strong></td>
              <td><span id="TotalAmountDue">21500</span> USD</td>
            </tr>
          </table>
        </div>
      </div>
      <div class="text-center">
        <a href="https://goldenplaza.com" class="btn btn-link">Try our free invoicing software - right in your browser <span class="border-bottom text-purple">Golden Plaza</span></a>
      </div>
      <div class="text-center mt-4">
        <button class="btn btn-download" onclick="downloadPDF()" id="cmd">Download PDF</button>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
  <script>
    function downloadPDF() {
      const { jsPDF } = window.jspdf;
      html2canvas(document.querySelector("#invoice")).then(canvas => {
        let pdf = new jsPDF('p', 'mm', 'a4');
        pdf.addImage(canvas.toDataURL("image/png"), 'PNG', 0, 0, 210, 297);
        pdf.save('invoice.pdf');
      });
    }
  </script>
</body>
</html>

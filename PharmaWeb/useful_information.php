<!DOCTYPE html>
<html lang="en" dir="ltr">

  <head>
    <meta charset="utf-8">
    <title>Online Pharmacy</title>
    <!--bootstrap file-->
    <link rel="stylesheet" href="bootstrap.css">
    <!--javaScript related links-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <!--own styles-->
    <link rel="stylesheet" href="style.css">
    <!--Add the font from web 11-->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
  </head>

  <body>
    <header class = "colorgr" >
      <!--Home button-->

      <?php
      $i = 0;
      if( $i == 1)
        include 'navBarLoggedin.php';
      else
        include 'navBarnotLoggedin.php';
       ?>

    </header>

    <section class ="article spc">
      <p>
      <h4>Buying Medicines Online</h4>
      All medicines that we supply are sourced from an authorised manufacturer
      or an authorised wholesaler. We ensure the quality and safety of the
      medicines, the security and integrity of the supply to eliminate the risk
      of counterfeit medicines entering the supply chain.

      You must be aged 18 years or over to purchase medicines online at
      www.inishpharmacy.com. By purchasing any medicines and agreeing to the
      terms and conditions at checkout you are confirming that you are over the
      age of 18 years.

      <h4>Record Keeping</h4>

      In accordance with legislation the records listed below will be retained securely for a period of two years from the date of purchase.
      <ol>
        <li>
          Every invoice for medicines we obtain, which include:
          <ul>
            <li>The date of the transaction</li>
            <li>The name and quantity of the product obtained</li>
            <li>The name and address of the supplier</li>
          </ul>
        </li>
        <li>
          A record of each transaction involving the supply of a medicine to our customers, including:
          <ul>
            <li>The order number</li>
            <li>The date of the transaction</li>
            <li>The name and quantity of the product supplied</li>
            <li>The name and address of the person to whom the product was supplied</li>
          </ul>
        </li>
        <li>
          A record to show that prior to supplying/dispatching of
          the product, the customer has confirmed that they agree with
          and understand the terms and conditions which include:
          <ul>
            <li>They are over 18 years old</li>
            <li>
              They are aware that the medicine should be used
               in accordance with the recommendations for use contained in
               the product packaging
            </li>
            <li>
              The total quantity of the product to be supplied in the transaction is a
               quantity that is reasonably required for the purchasers own treatment,
               having regard to any previous supply to that purchaser
            </li>
            <li>
              Where a maximum quantity to purchase is stated on a medicinal product,
              this is the maximum amount that we will supply in any one transaction.
              Repeat medicines purchases will be monitored
            </li>
            <li>
              Any medicines which are liable to abuse and/or misuse will be identified
               along with any repeat requests for medicines from the same customer.
               Where we suspect a medicine may be being abused or misused a supply will
                not be made and a full refund will be given
            </li>
          </ul>
        </li>
      </ol>

      In addition, a pharmacy supplying medicines via the internet record will
       be kept showing that prior to supply of the product our pharmacist has:
       <ul>
         <li>
             Personally reviewed each order for supply and personally
             supervised and authorised the supply
         </li>
         <li>
           Fulfilled the requirement of Regulation 10 of the
            Regulation of Retail Pharmacy Businesses Regulations 2008
            (S.I. No. 488 of 2008)
         </li>
       </ul>
       Regulation 10 of the Regulation of Retail Pharmacy Businesses Regulations
        2008 requires that in the course of the supply, a registered pharmacist
         is satisfied that the purchaser is aware of what the appropriate use
         of the medicine is and that it is being sought for that purpose and,
         in so far as the registered pharmacist is aware, the product is not
         intended for abuse and/or misuse.
         </p>
    </section>


    <footer class = "colorgr">
      <p class = "spc">Copyright stuff....</p>
    </footer>
  </body>
</html>

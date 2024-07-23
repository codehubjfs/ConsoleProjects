document.addEventListener("DOMContentLoaded", function() {
  // Scroll event for header
  window.addEventListener("scroll", function() {
      var header = document.getElementById("header");
      if (window.scrollY > 520) {
          header.classList.add("scrolled");
      } else {
          header.classList.remove("scrolled");
      }
  });

  // Function to display modal
   showModal=function() {
    var myModal = new bootstrap.Modal(document.getElementById('loginModal'), {
        keyboard: false
    });
    myModal.show();
}

// Function to close modal
closeModal = function() {
    var loginModal = new bootstrap.Modal(document.getElementById('loginModal'));
    loginModal.hide();
}

// Close modal when clicked outside of it
window.onclick = function(event) {
    var modal = document.getElementById('loginModal');
    if (event.target == modal) {
        closeModal();
    }
}

  // // Function to show login modal with user type
  // showLoginModal = function(userType) {
  //     var modalLabel = document.getElementById('loginModalLabel');
  //     modalLabel.innerText = userType + ' Login';
  //     var loginModal = new bootstrap.Modal(document.getElementById('loginModal'));
  //     loginModal.show();
  // }

  // GSAP animation for the title inside #anime
  const title = document.querySelector("#anime h1");
  if (title) {
      title.addEventListener("mouseenter", () => {
          gsap.to(".distort feDisplacementMap", 1, {
              attr: {
                  scale: 100
              },
              ease: "circ.out"
          });
          gsap.to(".distort feTurbulence", 1, {
              attr: {
                  baseFrequency: '2.08 .08'
              },
              ease: "circ.out"
          }, 1);
          gsap.to(title, 1, {
              fontVariationSettings: "'wght' 650",
              ease: "back.out"
          });
      });
      title.addEventListener("mouseleave", () => {
          gsap.to(".distort feDisplacementMap", 1, {
              attr: {
                  scale: 0
              },
              ease: "circ.out"
          }, 1);
          gsap.to(".distort feTurbulence", 1, {
              attr: {
                  baseFrequency: '2.01 .01'
              },
              ease: "circ.out"
          }, 1);
          gsap.to(title, 1, {
              fontVariationSettings: "'wght' 700",
              ease: "back.out"
          }, 1);
      });
  }

  // GSAP animation timeline for h1 background
  var tl = gsap.timeline({ repeat: -1 });
  tl.to("h1", 30, { backgroundPosition: "-800px 0" });
});



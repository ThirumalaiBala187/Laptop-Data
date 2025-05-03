const upload = document.getElementById('upload');
const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');
const downloadBtn = document.getElementById('downloadBtn');

upload.addEventListener('change', function () {
  const file = upload.files[0];
  if (!file) return;

  const reader = new FileReader();
  reader.onload = function (e) {
    const img = new Image();
    img.onload = function () {
      canvas.width = img.width;
      canvas.height = img.height;

      ctx.filter = 'blur(5px)';
      ctx.drawImage(img, 0, 0);

      downloadBtn.href = canvas.toDataURL();
    };
    img.src = e.target.result;
  };
  reader.readAsDataURL(file);
});
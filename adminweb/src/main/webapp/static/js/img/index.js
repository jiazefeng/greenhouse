(function () {
    var file0 = document.querySelector('#gUrlFile');
    // input.onchange = function () {
    //     lrz(this.files[0], {width: 300}, function (results) {
    //         // 你需要的数据都在这里，可以以字符串的形式传送base64给服务端转存为图片。
    //         console.log(results);
    //         // 以下为演示用内容
    //         var
    //             // tip = document.querySelector('#tip'),
    //             report = document.querySelector('#report');
    //         // footer = document.querySelector('footer');
    //
    //         // report.innerHTML = footer.innerHTML = '';
    //         report.innerHTML = '';
    //         // tip.innerHTML = '<p>正在生成和上传..</p> <small class="text-muted">演示使用了大量内存，可能会造成几秒内卡顿，不代表真实表现，请亲测。</small>';
    //         // demo_report('原始图片', results.blob, results.origin.size);
    //         demo_report('客户端预压的图片', results.base64, results.base64.length * 0.8);
    //         // setTimeout(function () {
    //         //     demo_report('客户端预压的图片', results.base64, results.base64.length * 0.8);
    //         //     // 发送到后端
    //         //     // var xhr = new XMLHttpRequest();
    //         //     // var data = {
    //         //     //     base64: results.base64,
    //         //     //     size: results.base64.length // 校验用，防止未完整接收
    //         //     // };
    //         //     // xhr.open('POST', '/');
    //         //     // xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
    //         //     // xhr.onreadystatechange = function () {
    //         //     //     if (xhr.readyState === 4 && xhr.status === 200) {
    //         //     //         var result = JSON.parse(xhr.response);
    //         //     //         result.error ? alert('服务端错误，未能保存图片') : demo_report('服务端实存的图片', result.src, result.size);
    //         //     //         // tip.innerHTML = '<p>生成和上传完毕</p> <small class="text-muted">演示使用了大量内存，可能会造成几秒内卡顿，不代表真实表现，请亲测。</small>';
    //         //     //     }
    //         //     // };
    //         //     // xhr.send(JSON.stringify(data)); // 发送base64
    //         // }, 100);
    //     });
    // };
    file0.onchange = function () {
        var report = document.querySelector('#report');
        report.innerHTML = '';
        lrz(this.files[0], {width: 300,height:200}, function (results) {
            demo_report('客户端预压的图片', results.base64, results.base64.length * 0.8, report);
        });
    }
    /**
     * 演示报告
     * @param title
     * @param src
     * @param size
     */
    function demo_report(title, src, size, report) {
        var img = new Image(),
            li = document.createElement('li'),
            size = (size / 1024).toFixed(2) + 'KB';
        img.onload = function () {
            var content = '<ul>' +
                '<li>' + title + '（' + img.width + ' X ' + img.height + '）</li>' +
                '<li class="text-cyan">' + size + '</li>' +
                '</ul>';
            li.className = 'item-img';
            // li.innerHTML = content;
            li.appendChild(img);
            // document.querySelector('#report').appendChild(li);
            report.appendChild(li);
        };
        img.src = src;
    }

    // 演示用服务器太慢，做个延缓加载
    window.onload = function () {
        file0.style.display = 'block';
    }
})();
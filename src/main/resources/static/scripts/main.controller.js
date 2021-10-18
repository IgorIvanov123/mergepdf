angular.module('mergepdfapp').controller('mainController', function mainControllerFunction($scope, $http, $cookies) {

    $scope.isAuth = false;
    $scope.files = [];
    $scope.mergedFiles = [];
    $scope.file = {}; //Model
    $scope.options = {
    //Called for each selected file
        change: function (file) {
            //file contains info about the uploaded file
            //uploading to server
        }
    }

    $scope.checkToken = function() {
        var token = $cookies.get("session1_token");
        if(token == undefined) {
            $http.post("generateToken").then(
                function(response) {
                    console.log(response);
                    $cookies.put("session1_token", response.data.token);
                    $scope.isAuth = true;
                    $scope.files = response.data.uploadedFiles;
                    $scope.mergedFiles = response.data.mergedFiles;
                },
                function(response) {
                    console.log(response);
                }
            )
        } else {
            $scope.isAuth = true;
            $http.post("getFiles").then(
                function(response) {
                    console.log(response);
                    $scope.files = response.data.uploadedFiles;
                    $scope.mergedFiles = response.data.mergedFiles;
                },
                function(response) {
                    console.log(response);
                }
            )
        }
    }

    $scope.send = function() {
        var formData = new FormData();
        for(var file of document.getElementById("pdfinput").files) {
            formData.append("inputFiles", file);
        }
        requestConfig = {"headers": {"Content-Type": undefined}}
        $http.post("send", formData, requestConfig).then(
            function(response) {
                console.log(response);
            },
            function(response) {
                console.log(response);
            }
        );
    }

    $scope.checkToken();
})


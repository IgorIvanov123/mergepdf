angular.module('mergepdfapp').controller('mainController', function mainControllerFunction($scope, $http) {
    $scope.cats = ['pushok', 'murzik'];
    $scope.message = "12";
    $scope.fun = function(){
        console.log($scope.message);
    }
})
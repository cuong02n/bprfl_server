import sklearn.model_selection
from sklearn.naive_bayes import GaussianNB
from sklearn.naive_bayes import MultinomialNB
import sys
import numpy as np

if __name__ == '__main__':
    # python test.py test
    # argv[0] : file name
    # argv[1] : prefix file with the training data
    # argv[2] : number of chapter = n : 0 -> n - 1

    clf = []
    for i in range(int(sys.argv[2])):
        with open(str(sys.argv[1]) + str(i), 'r+') as file:
            X = []
            Y = []
            for line in file:
                k = list(map(int, line.split()))
                Y.append(k[-1])
                k.pop()
                X.append(k)
            x_train, x_test, y_train, y_test = sklearn.model_selection.train_test_split(X, Y, test_size=1,
                                                                                        random_state=42)
            _clf = MultinomialNB()
            _clf.fit(x_train, y_train)
            clf.append(_clf)
            # accuracy = sklearn.metrics.accuracy_score(y_pred=y_predict, y_true=y_test)
            # print(accuracy)
    while (True):
        # input: argv[2] line:
        # each line : argv[3] element
        try:
            Y = []
            for i in range(int(sys.argv[2])):
                x = list(map(int, input().split()))
                Y.append(clf[i].predict([x])[0])
            for i in range(int(sys.argv[2])):
                print(Y[i], end=' ')
            print()
        except Exception as e:
            print(str(e))

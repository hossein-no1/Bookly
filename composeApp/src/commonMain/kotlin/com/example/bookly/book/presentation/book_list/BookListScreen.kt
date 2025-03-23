package com.example.bookly.book.presentation.book_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import bookly.composeapp.generated.resources.Res
import bookly.composeapp.generated.resources.favorites
import bookly.composeapp.generated.resources.no_favorite_books
import bookly.composeapp.generated.resources.no_search_results
import bookly.composeapp.generated.resources.search_results
import com.example.bookly.book.domain.Book
import com.example.bookly.book.presentation.book_list.component.BookList
import com.example.bookly.book.presentation.book_list.component.BookSearchBar
import com.example.bookly.core.presentation.DarkBlue
import com.example.bookly.core.presentation.DesertWhite
import com.example.bookly.core.presentation.SandYellow
import com.example.bookly.core.presentation.UiText
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreen(
    modifier: Modifier = Modifier,
    viewModel: BookListViewModel = koinViewModel(),
    onBookClick: (Book) -> Unit
) {

    val state by viewModel.state.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val pagerState = rememberPagerState { 2 }
    val searchResultsListState = rememberLazyListState()
    val favoriteBooksListState = rememberLazyListState()

    Content(
        modifier = modifier,
        searchQuery = state.searchQuery,
        selectedTabIndex = state.selectedTabIndex,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage,
        searchResultList = state.searchResultList,
        favoriteBookList = state.favoriteBookList,
        keyboardController = keyboardController,
        pagerState = pagerState,
        searchResultsListState = searchResultsListState,
        favoriteBooksListState = favoriteBooksListState,
        onAction = {
            when (it) {
                is BookListAction.OnBookClick -> onBookClick(it.book)
                else -> viewModel.onAction(action = it)
            }
        }
    )

}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    searchQuery: String,
    selectedTabIndex: Int,
    isLoading: Boolean,
    errorMessage: UiText?,
    searchResultList: List<Book>,
    favoriteBookList: List<Book>,
    keyboardController: SoftwareKeyboardController?,
    pagerState: PagerState,
    searchResultsListState: LazyListState,
    favoriteBooksListState: LazyListState,
    onAction: (BookListAction) -> Unit
) {

    LaunchedEffect(searchResultList) {
        searchResultsListState.animateScrollToItem(0)
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage) {
        onAction(BookListAction.OnTabSelected(pagerState.currentPage))
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = DarkBlue)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BookSearchBar(
            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxWidth()
                .padding(all = 16.dp),
            searchQuery = searchQuery,
            onSearchQueryChange = {
                onAction(BookListAction.OnSearchQueryChange(it))
            },
            onImeSearch = {
                keyboardController?.hide()
            }
        )

        Tabs(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            selectedTabIndex = selectedTabIndex,
            isLoading = isLoading,
            errorMessage = errorMessage,
            searchResultList = searchResultList,
            favoriteBookList = favoriteBookList,
            pagerState = pagerState,
            searchResultsListState = searchResultsListState,
            favoriteBooksListState = favoriteBooksListState,
            onAction = onAction,
        )

    }

}

@Composable
private fun Tabs(
    modifier: Modifier = Modifier,
    selectedTabIndex: Int,
    isLoading: Boolean,
    errorMessage: UiText?,
    searchResultList: List<Book>,
    favoriteBookList: List<Book>,
    pagerState: PagerState,
    searchResultsListState: LazyListState,
    favoriteBooksListState: LazyListState,
    onAction: (action: BookListAction) -> Unit
) {

    Surface(
        modifier = modifier,
        color = DesertWhite,
        shape = RoundedCornerShape(
            topStart = 32.dp,
            topEnd = 32.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .widthIn(max = 700.dp)
                    .fillMaxWidth(),
                containerColor = DesertWhite,
                indicator = { tabPositions ->
                    TabRowDefaults.SecondaryIndicator(
                        color = SandYellow,
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    )
                }
            ) {
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = {
                        onAction(BookListAction.OnTabSelected(0))
                    },
                    modifier = Modifier.weight(1f),
                    selectedContentColor = SandYellow,
                    unselectedContentColor = Color.Black.copy(alpha = 0.5f)
                ) {
                    Text(
                        text = stringResource(Res.string.search_results),
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                    )
                }
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = {
                        onAction(BookListAction.OnTabSelected(1))
                    },
                    modifier = Modifier.weight(1f),
                    selectedContentColor = SandYellow,
                    unselectedContentColor = Color.Black.copy(alpha = 0.5f)
                ) {
                    Text(
                        text = stringResource(Res.string.favorites),
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { pageIndex ->
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    when (pageIndex) {
                        0 -> {
                            if (isLoading) {
                                CircularProgressIndicator()
                            } else {
                                when {
                                    errorMessage != null -> {
                                        Text(
                                            text = errorMessage.asString(),
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    }

                                    searchResultList.isEmpty() -> {
                                        Text(
                                            text = stringResource(Res.string.no_search_results),
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    }

                                    else -> {
                                        BookList(
                                            bookList = searchResultList,
                                            onBookClick = {
                                                onAction(BookListAction.OnBookClick(it))
                                            },
                                            modifier = Modifier.fillMaxSize(),
                                            scrollState = searchResultsListState
                                        )
                                    }
                                }
                            }
                        }

                        1 -> {
                            if (favoriteBookList.isEmpty()) {
                                Text(
                                    text = stringResource(Res.string.no_favorite_books),
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.headlineSmall,
                                )
                            } else {
                                BookList(
                                    bookList = favoriteBookList,
                                    onBookClick = {
                                        onAction(BookListAction.OnBookClick(it))
                                    },
                                    modifier = Modifier.fillMaxSize(),
                                    scrollState = favoriteBooksListState
                                )
                            }
                        }
                    }
                }
            }
        }

    }

}
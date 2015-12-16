/*
 * 
 */
package com.indra.iquality.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.UnsupportedDataTypeException;

import com.indra.iquality.model.DictionaryConcept;

/**
 * The Class GenericTreeNode. Represents a tree node of a generic type.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class GenericTreeNode.
 * @param <T>
 *            the generic type
 */
public class GenericTreeNode<T> {

	/** The data to store in the node. */
	private T data;

	/** The children. */
	private List<GenericTreeNode<T>> children;

	/** The parent. */
	private GenericTreeNode<T> parent;

	/**
	 * Instantiates a new generic tree node.
	 */
	public GenericTreeNode() {
		super();
		children = new ArrayList<GenericTreeNode<T>>();
	}

	/**
	 * Instantiates a new generic tree node with a given data.
	 *
	 * @param data
	 *            the data
	 */
	public GenericTreeNode(T data) {
		this();
		setData(data);
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public GenericTreeNode<T> getParent() {
		return this.parent;
	}

	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public List<GenericTreeNode<T>> getChildren() {
		return this.children;
	}

	/**
	 * Gets the number of children.
	 *
	 * @return the number of children
	 */
	public int getNumberOfChildren() {
		return getChildren().size();
	}

	/**
	 * Checks if the node has children.
	 *
	 * @return true, if successful
	 */
	public boolean hasChildren() {
		return (getNumberOfChildren() > 0);
	}

	/**
	 * Sets the children.
	 *
	 * @param children
	 *            the new children
	 */
	public void setChildren(List<GenericTreeNode<T>> children) {
		for (GenericTreeNode<T> child : children) {
			child.parent = this;
		}

		this.children = children;
	}

	/**
	 * Adds a child at the end of the current children.
	 *
	 * @param child
	 *            the child
	 */
	public void addChild(GenericTreeNode<T> child) {
		child.parent = this;
		children.add(child);
	}

	/**
	 * Adds a new child at a given position.
	 *
	 * @param index
	 *            the index where to insert
	 * @param child
	 *            the child
	 * @throws IndexOutOfBoundsException
	 *             if the the insertion was meant outside the children
	 */
	public void addChildAt(int index, GenericTreeNode<T> child) throws IndexOutOfBoundsException {
		child.parent = this;
		children.add(index, child);
	}

	/**
	 * Removes all the children.
	 */
	public void removeChildren() {
		this.children = new ArrayList<GenericTreeNode<T>>();
	}

	/**
	 * Removes the child at the given index.
	 *
	 * @param index
	 *            the index to remove
	 * @throws IndexOutOfBoundsException
	 *             if the the removal was meant outside the children
	 */
	public void removeChildAt(int index) throws IndexOutOfBoundsException {
		children.remove(index);
	}

	/**
	 * Gets the child at a given index.
	 *
	 * @param index
	 *            the index
	 * @return the child at the given index
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of the bounds of chilrden
	 */
	public GenericTreeNode<T> getChildAt(int index) throws IndexOutOfBoundsException {
		return children.get(index);
	}

	/**
	 * Gets the data of the node.
	 *
	 * @return the data
	 */
	public T getData() {
		return this.data;
	}

	/**
	 * Sets the data of the node.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getData().toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		GenericTreeNode<?> other = (GenericTreeNode<?>) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	/**
	 * Gets a verbose representation of the node, i. e., the data and all the
	 * children.
	 *
	 * @return the verbose string representation of the node
	 */
	public String toStringVerbose() {
		String stringRepresentation = getData().toString() + ":[";

		for (GenericTreeNode<T> node : getChildren()) {
			stringRepresentation += node.getData().toString() + ", ";
		}

		// Pattern.DOTALL causes ^ and $ to match. Otherwise it won't. It's
		// retarded.
		Pattern pattern = Pattern.compile(", $", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(stringRepresentation);

		stringRepresentation = matcher.replaceFirst("");
		stringRepresentation += "]";

		return stringRepresentation;
	}

	/**
	 * Recursively prints the whole tree hanging from the node in a verbose
	 * manner: the data, the level and the children. It only works when the type
	 * T of the node is {@link com.indra.iquality.model.DictionaryConcept}.
	 *
	 * @param level
	 *            the level of the node
	 * @throws UnsupportedDataTypeException
	 *             if the data type of the node is not
	 *             {@link com.indra.iquality.model.DictionaryConcept}
	 */
	public void myPrintTree(int level) throws UnsupportedDataTypeException {

		if (!(this.data instanceof DictionaryConcept))
			throw new UnsupportedDataTypeException();

		for (int i = 0; i < level; ++i) {
			System.out.print("## ");
		}

		System.out.println("level " + level + " -> [" + ((DictionaryConcept) getData()).getType() + "] "
				+ ((DictionaryConcept) getData()).getConcept());

		for (GenericTreeNode<T> node : getChildren()) {
			node.myPrintTree(level + 1);
		}
	}
}
